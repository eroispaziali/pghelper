package io.lofrattini.pghelper;

import java.net.URI;

public class DatabaseSource {
	
	private String scheme;
	private String host;
	private String username;
	private String password;
	private Integer port;
	private String database;
	
	public DatabaseSource(String databaseUrl)  {
		try {
			URI dbUri = new URI(databaseUrl);
			this.scheme = dbUri.getScheme();
			this.username = dbUri.getUserInfo().split(":")[0];
			this.password = dbUri.getUserInfo().split(":")[1];
			this.host =  dbUri.getHost();
			this.port = dbUri.getPort();
			this.database = dbUri.getPath().replaceFirst("/", "");
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUri() {
		return String.format("%s://%s:%s@%s:%d/%s", scheme, username, password, host, port, database);
	}

}
