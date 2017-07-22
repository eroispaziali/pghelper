package io.lofrattini.pghelper;

public class Launcher {
	
	private static String getPart(String databaseUrl, String part) {
		DatabaseSource source = new DatabaseSource(databaseUrl);
		switch (part.toLowerCase()) {
			case "host" : return source.getHost();
			case "port" : return source.getPort().toString();
			
			case "username" :
			case "user" : return source.getUsername();
			
			case "password": return source.getPassword();
			
			case "database":
			case "db" :
			case "dbname": return source.getDatabase();
			default :
				return "";
		}
	}

	public static void main(String[] args) {
		try{ 
			System.out.println(getPart(args[0], args[1]));
		} catch (Exception e ) {
		}
	}

}
