package app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;

public class Configuration {
	
	// shamelessly curl'ed from chef Alcides
	
	private static Configuration INSTANCE = null;
	
	public static Configuration getInstance() {
		if (INSTANCE == null) {
			 INSTANCE = new Configuration();
		}
		return INSTANCE;
	}
	
	private Properties prop = new Properties();
	
	private Configuration() {
		try {
			prop.load(new FileInputStream("pleilist.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Nao existe ficheiro pleilist.properties");
		} catch (IOException e) {
			System.out.println("Ocorreu erro na leitura do ficheiro pleilist.properties");
			e.printStackTrace();
		}
	}

	public int getInt(String chave) {
		return Integer.parseInt(prop.getProperty(chave));
	}
	
	public String getString(String chave) {
		return prop.getProperty(chave);
	}

	public String[] getStringArray(String chave) {
		return getString(chave).split(";");
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T createInstance(String className, T defaultObject) {
		Class<T> c = null;
		try {
			c = (Class<T>) Class.forName(className);
			
		} catch (ClassNotFoundException e1) {
			System.out.println("Nao existe a classe: " + className);
		} catch (SecurityException e) {
			System.out.println("Ocorreu um erro na criacao da classe " + className + " por motivos de seguranca");
			e.printStackTrace();
		}
		T ins = defaultObject;
		try {
			Constructor<T> cons = c.getConstructor();
			ins = cons.newInstance();
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na criacao da classe " + className);
			e.printStackTrace();
		}
		return ins;
	}

	@SuppressWarnings("unchecked")
	public <T> Iterable<T> getInstances(String chave, T defaultObject) {
		return (Iterable<T>) Arrays.stream(this.getStringArray(chave)).map((x) -> this.createInstance(x, defaultObject));
	}

	public <T> T createInstanceFromKey(String chave, T defaultObject) {
		String className = this.getString(chave);
		return this.createInstance(className, defaultObject);
	}
	
}
