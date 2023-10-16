package cl.ndt.sir.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cl.ndt.sir.dao.RendicionesDao;
import cl.ndt.sir.dao.UsuarioManager;
import cl.ndt.sir.model.DatosFtp;
import cl.ndt.sir.model.Usuario;
import net.sf.json.JSONArray;

public class ServiceRendicionController implements Controller {

	protected final Log log = LogFactory.getLog(getClass());

	private UsuarioManager usuarioManager;
	private RendicionesDao rendicionesDao;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Usuario user = usuarioManager.obtenerUsuarioLogueado();

		JSONArray array = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();
		Map<String, Object> outParameterA = new HashMap<String, Object>();
		Map<String, Integer> metodos = new HashMap<String, Integer>();

		metodos.put("rendicionNueva", 0);

		String metodo = request.getParameter("metodo");

		switch (metodos.get(metodo)) {
		case 0:
			outParameterA = registrarConciliacion(request, response, user);
			break;
		}

		array = JSONArray.fromObject(outParameterA);
		respuesta.put("json_respuesta", array);

		ModelAndView modelAndView = new ModelAndView("/servicios/servicio_rendicion", "mapa", respuesta);
		return modelAndView;

	}

	private Map<String, Object> registrarConciliacion(HttpServletRequest request, HttpServletResponse response,
			Usuario user) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String resultadoCarga = "Se han cargado las rendiciones y han quedado con estado en proceso.";
		String cod = "00";
		// CAPTURA FECHA INGRESADA
		String date = request.getParameter("date");
		String idCon = request.getParameter("idCon");

		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

		MultipartFile archivo = req.getFile("archivo");

		// NOMBRE ARCHIVO SUBIDO
		String nombreArchivo = archivo.getOriginalFilename();

		if (nombreArchivo.contains(".txt") || nombreArchivo.contains(".dat") || nombreArchivo.contains(".csv")) {
			String razonSocial = "", codigoComercio = "", nombreFantasia = "", producto = "", fechaAbono = "",
					abonoCalculado = "";

			Scanner obj = new Scanner(archivo.getInputStream());

			Integer count = 0;

			while (obj.hasNextLine() && (razonSocial.isEmpty() || codigoComercio.isEmpty() || nombreFantasia.isEmpty()
					|| producto.isEmpty() || fechaAbono.isEmpty() || abonoCalculado.isEmpty()) && count < 40) {
				count++;
				String linea = obj.nextLine();

				log.info(linea);

				if (linea.toLowerCase().contains("nombre o raz")) {
					razonSocial = linea.split(";")[1].toUpperCase();
				}

				if (linea.toLowerCase().contains("digo local")) {
					codigoComercio = linea.split(";")[1].toUpperCase();
				}

				if (linea.toLowerCase().contains("nombre fantas")) {
					nombreFantasia = linea.split(";")[1].toUpperCase();
				}

				if (linea.toLowerCase().contains("producto")) {
					if (linea.split(";")[1].contains("Tarjetas de Cr")) {
						producto = "TC";
					} else {
						producto = "TD";
					}
				}

				if (linea.toLowerCase().contains("de abono")) {
					fechaAbono = linea.split(";")[1].toUpperCase();
				}

				if (linea.toLowerCase().contains("abono calculado")) {
					abonoCalculado = linea.split(";")[1].toUpperCase();
				}

			}

			if (razonSocial.isEmpty() || codigoComercio.isEmpty() || nombreFantasia.isEmpty() || producto.isEmpty()
					|| fechaAbono.isEmpty() || abonoCalculado.isEmpty()) {
				resultadoCarga = "Archivo sin parametros necesarios para cargar";
				cod = "03";
			} else {
				// INSERTAR RENDICION
				Map<String, Object> rend = rendicionesDao.cargarRendiciones(date, nombreArchivo, user.getId(),
						user.getEmpresa().getId(), razonSocial, codigoComercio, nombreFantasia, producto, fechaAbono,
						abonoCalculado, idCon);

				if (rend.get("NCOD_SALIDA_OUT").equals("00")) {
					String filePath = System.getProperty("jboss.server.config.dir");

					filePath = filePath + "/respaldo/" + "REND_" + rend.get("RESULTADO_OUT") + "_"
							+ date.replace("/", "");

					InputStream inputStream = null;
					OutputStream outputStream = null;

					try {
						// read this file into InputStream
						inputStream = archivo.getInputStream();

						// req.getFile("archivo").getInputStream();

						// write the inputStream to a FileOutputStream
						outputStream = new FileOutputStream(new File(filePath));

						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}

						log.info("Alojado en respaldo");

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (inputStream != null) {
							try {
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (outputStream != null) {
							try {
								// outputStream.flush();
								outputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}

					DatosFtp datosFtp = rendicionesDao.obtenerDatosFtp(user.getEmpresa().getId(), "Rendicion");

					if (datosFtp != null) {
						SCPFileTransger(filePath, datosFtp.getUsuario(), datosFtp.getServer(), datosFtp.getRuta());
					} else {
						resultadoCarga = "No se encontraron datos para FTP";
						cod = "01";
					}
				} else {
					resultadoCarga = "no se cargó el archivo";
					cod = "02";
				}
			}
		}else {
			resultadoCarga = "Extención de archivo no permitido, favor solo subir archivo .txt, .dat o .csv";
			cod = "03";
		}

		Map<String, Object> outParameterA = new HashMap<String, Object>();

		log.info(resultadoCarga);
		log.info(cod);
		outParameterA.put("mensaje", resultadoCarga);
		outParameterA.put("cod", cod);

		return outParameterA;
	}

	public void SCPFileTransger(String fileName, String user, String host, String rutaFinal) {
		String com = "scp " + fileName + " " + user + host + rutaFinal;
		String[] comando = new String[] { "bash", "-c", com };

		log.info(com);
		String output = executeCommand(comando);

		log.info(output);

	}

	private static String executeCommand(String[] command) {

		StringBuffer output = new StringBuffer();

		ProcessBuilder process = new ProcessBuilder(command);
		Process p = null;
		try {
			p = process.start();
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			p.destroy();
		}

		return output.toString();

	}

	public void setUsuarioManager(UsuarioManager usuarioManager) {
		this.usuarioManager = usuarioManager;
	}

	public void setRendicionesDao(RendicionesDao rendicionesDao) {
		this.rendicionesDao = rendicionesDao;
	}

}
