package com.clinica.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Map.Entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.clinica.bd.*;


public class Generador {

	public static void main(String[] args)  throws InterruptedException{     
        
        final File carpeta = new File("F:\\formatos\\json");
        existeArchivo(carpeta);
	}
	
	public static Boolean existeArchivo(final File carpeta) throws InterruptedException{
		
		Boolean existe = false;
		
		
		
		String stringToParse = "{ \"cabecera\": {\"tipOperacion\": \"01\", \"fecEmision\" : \"2019-02-22\", \"tipDocUsuario\" : \"6\", \"numDocUsuario\" : \"20431115825\", \"rznSocialUsuario\" : \"<![CDATA[PacĂ­fico S.A. EPS.]]>\", \"tipMoneda\" : \"PEN\", \"sumDsctoGlobal\" : \"52.20\", \"mtoDescuentos\" : \"52.20\", \"mtoOperGravadas\" : \"260.63\", \"mtoOperInafectas\" : \"0.00\", \"mtoOperExoneradas\" : \"0.00\", \"mtoIGV\" : \"46.91\", \"mtoImpVenta\" : \"307.54\"}, \"detalle\" : [{ \"codUnidadMedida\" : \"NIU\", \"ctdUnidadItem\" : \"1.00\", \"desItem\" : \"<![CDATA[CONSULTA AMBULATORIA POR MEDICO ESPECIALISTA]]>\", \"mtoValorUnitario\" : \"45.00\", \"mtoIgvItem\" : \"8.10\", \"tipAfeIGV\" : \"10\", \"mtoPrecioVentaItem\" : \"45.00\", \"mtoValorVentaItem\" : \"45.00\" }, { \"codUnidadMedida\" : \"NIU\", \"ctdUnidadItem\" : \"1.00\", \"desItem\" : \"<![CDATA[ECOGRAFIA DE EXTREMIDAD - MUSCULAR Y PARTES BLANDAS - UNILATERAL]]>\", \"mtoValorUnitario\" : \"104.50\", \"mtoIgvItem\" : \"18.81\", \"tipAfeIGV\" : \"10\", \"mtoPrecioVentaItem\" : \"104.50\", \"mtoValorVentaItem\" : \"104.50\" }, { \"codUnidadMedida\" : \"NIU\", \"ctdUnidadItem\" : \"1.00\", \"desItem\" : \"Farmacia e Insumos 191208 - \", \"mtoValorUnitario\" : \"163.33\", \"mtoIgvItem\" : \"29.40\", \"tipAfeIGV\" : \"10\", \"mtoPrecioVentaItem\" : \"163.33\", \"mtoValorVentaItem\" : \"163.33\" }]}";
//		DriverManager.getConnection("jdbc:sqlite::resource:package/test.db");
		
		JsonObject jsonObject = new JsonParser().parse(stringToParse).getAsJsonObject();

        String pageName = jsonObject.getAsJsonObject("cabecera").get("tipOperacion").getAsString();
        System.out.println(pageName);
        
        
        JsonArray arr = jsonObject.getAsJsonArray("detalle");
        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).getAsJsonObject().get("desItem").getAsString();
            System.out.println(post_id);
        }

        Sqlite.connect();
//        
//		JsonParser parser = new JsonParser();
//		JsonObject json = (JsonObject) parser.parse(stringToParse);
//		
////		System.out.println(json.getAsJsonObject("cabecera").getAsJsonObject("tipOperacion"));
//		
//		JsonObject jsonCabecera = (JsonObject) json.getAsJsonObject("cabecera");
//		
//		System.out.println(jsonCabecera.getString("tipOperacion"));
//		System.out.println(jsonCabecera.get("fecEmision").toString());
//		System.out.println(jsonCabecera.get("tipDocUsuario").toString());
//		System.out.println(jsonCabecera.get("numDocUsuario").toString());
//		System.out.println(jsonCabecera.get("rznSocialUsuario").toString());
//		String input = jsonCabecera.get("rznSocialUsuario").toString();
//		try {
//			String palabar = new String(input.getBytes("UTF-8"),"ISO-8859-1");
//			System.out.println(palabar);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/* for (final File ficheroEntrada : carpeta.listFiles()) {
		            System.out.println("Archivo: "+ficheroEntrada.getName());
		            
		            JsonParser parser = new JsonParser();
		            FileReader fr;
					try {
						fr = new FileReader("F:\\formatos\\json\\"+ficheroEntrada.getName().toString());
						JsonElement datos = parser.parse(fr);
			            dumpJSONElement(datos);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
					
					 long start = System.currentTimeMillis(); 
					 Thread.sleep(2000);
					 System.out.println("==========================================================");
					 System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start)); 
					 
		}*/
		
//		 long start = System.currentTimeMillis(); 
//		 Thread.sleep(4000);
//		 System.out.println("==========================================================");
//		 System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start)); 
//		 existeArchivo(carpeta);
		return existe;
		
	}

	
	
}
