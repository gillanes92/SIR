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

public class ServiceTransaccionController implements Controller {

	protected final Log log = LogFactory.getLog(getClass());

	private UsuarioManager usuarioManager;
	private RendicionesDao rendicionesDao;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Usuario user = usuarioManager.obtenerUsuarioLogueado();

		JSONArray array = null;
		Map<String, Object> respuesta = new HashMap<String, Object>();
		Map<String, Object> outParameterA = new HashMap<String, Object>();
		Map<String, Integer> metodos = new HashMap<String, Integer>();

		metodos.put("pagoNuevo", 0);

		String metodo = request.getParameter("metodo");

		switch (metodos.get(metodo)) {
		case 0:
			outParameterA = registrarPago(request, response, user);
			break;
		}

		array = JSONArray.fromObject(outParameterA);
		respuesta.put("json_respuesta", array);

		ModelAndView modelAndView = new ModelAndView("/servicios/servicio_transaccion", "mapa", respuesta);
		return modelAndView;

	}

	private Map<String, Object> registrarPago(HttpServletRequest request, HttpServletResponse response, Usuario user)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String resultadoCarga = "Se ha registrado el archivo y en unos minutos se comenzará a procesar.";
		String cod = "00";
		// CAPTURA FECHA INGRESADA
		String date = request.getParameter("date");
		String idConc = request.getParameter("idCon");

		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

		MultipartFile archivo = req.getFile("archivo");

		// NOMBRE ARCHIVO SUBIDO
		String nombreArchivo = archivo.getOriginalFilename();
		
		if(nombreArchivo.contains(".csv")) {
			// INSERTAR RENDICION
			Map<String, Object> rend = rendicionesDao.cargarPago(date, nombreArchivo, user.getId(),
					user.getEmpresa().getId(), idConc);

			if (rend.get("NCOD_SALIDA_OUT").equals("00")) {
				String filePath = System.getProperty("jboss.server.config.dir");

				filePath = filePath + "/respaldo/" + rend.get("RESULTADO_OUT");

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

				DatosFtp datosFtp = rendicionesDao.obtenerDatosFtp(user.getEmpresa().getId(), "pago");

				if (datosFtp != null) {
					SCPFileTransger(filePath, datosFtp.getUsuario(), datosFtp.getServer(), datosFtp.getRuta());
				} else {
					resultadoCarga = "No se encontraron datos para FTP";
					cod = "01";
				}
			} else {
				resultadoCarga = "No se cargó el archivo";
				cod = "02";
			}
		}else {
			resultadoCarga = "Extención de archivo no permitido, favor solo subir archivo .csv";
			cod = "03";
		}
		
		

		Map<String, Object> outParameterA = new HashMap<String, Object>();

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
