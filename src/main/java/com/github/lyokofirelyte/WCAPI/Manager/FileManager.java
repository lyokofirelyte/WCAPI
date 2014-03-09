package com.github.lyokofirelyte.WCAPI.Manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import com.github.lyokofirelyte.WCAPI.WCAPI;
import com.github.lyokofirelyte.WCAPI.WCLink;

public class FileManager extends WCLink {

	public FileManager(WCAPI i) {
		super(i);
	}

	private HashMap<File, YamlConfiguration> configs = new HashMap<File, YamlConfiguration>();
	
	public File getFile(String name){

		List<String> nameSplit = Arrays.asList(name.split("/"));
		
		for (File file : configs.keySet()){
			if (file.getName().equals(nameSplit.get(nameSplit.size()-1) + ".yml")){
				return file;
			}
		}
		
		return null;
	}

	public YamlConfiguration getConfig(String name){

		File file = getFile(name);

		if (configs.containsKey(file)){
			return configs.get(file);
		}
		
		return null;

	}

	public boolean saveConfig(String name){

		try {
			YamlConfiguration yaml = getConfig(name);
			File file = getFile(name);
			yaml.save(file);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public YamlConfiguration registerConfig(String name){

		if (!pl.getDataFolder().exists()){
			pl.getDataFolder().mkdirs();
		}

		if (!configs.containsKey(name)){

			String ext = name + ".yml";
			File file = new File(pl.getDataFolder(), ext);
			
			if (!(file.exists())){
				copy(pl.getResource(ext), file);
			}
			
			YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
			configs.put(file, yaml);
			return yaml;
		}
		
		return null;
	}

	private void copy(InputStream in, File file){

		try {
			if (in == null){
				file.createNewFile();
			} else {
				OutputStream out = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int len;

				while ((len = in.read(buf)) > 0){
					out.write(buf, 0, len);
				}

				out.close();
				in.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}