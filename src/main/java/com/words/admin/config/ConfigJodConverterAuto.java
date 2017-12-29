package com.words.admin.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jodconverter.DocumentConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.LocalOfficeManager.Builder;
import org.jodconverter.office.OfficeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//@Configuration
@PropertySource("classpath:app.properties")
public class ConfigJodConverterAuto {
	@Autowired
	Environment env;
	private final PropertiesJodConverter properties;

	public ConfigJodConverterAuto() {
		this.properties = new PropertiesJodConverter();
		// System.out.println(env.containsProperty("jodconverter.officeHome"));
		this.properties.setOfficeHome(env.getProperty("jodconverter.officeHome"));
		// this.properties.setEnabled(true);
		// this.properties.setPortNumbers(env.getProperty("jodconverter.portNumbers"));
		// String maxTasksPerProcess =
		// env.getProperty("jodconverter.maxTasksPerProcess");
		// this.properties.setMaxTasksPerProcess(Integer.parseInt(maxTasksPerProcess));
		// this.properties.setWorkingDir(env.getProperty("jodconverter.workingDir"));

	}

	public OfficeManager createOfficeManager() {
		Builder builder = LocalOfficeManager.builder();
		if (!StringUtils.isBlank(this.properties.getPortNumbers())) {
			Set<Integer> iports = new HashSet<Integer>();
			String[] var3 = StringUtils.split(this.properties.getPortNumbers(), ", ");
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				String portNumber = var3[var5];
				iports.add(NumberUtils.toInt(portNumber, 2002));
			}

			builder.portNumbers(ArrayUtils.toPrimitive((Integer[]) iports.toArray(new Integer[iports.size()])));
		}

		builder.officeHome(this.properties.getOfficeHome());
		builder.workingDir(this.properties.getWorkingDir());
		builder.templateProfileDir(this.properties.getTemplateProfileDir());
		builder.killExistingProcess(this.properties.isKillExistingProcess());
		builder.processTimeout(this.properties.getProcessTimeout());
		builder.processRetryInterval(this.properties.getProcessRetryInterval());
		builder.taskExecutionTimeout(this.properties.getTaskExecutionTimeout());
		builder.maxTasksPerProcess(this.properties.getMaxTasksPerProcess());
		builder.taskQueueTimeout(this.properties.getTaskQueueTimeout());
		return builder.build();
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public OfficeManager officeManager() {
		return this.createOfficeManager();
	}

	@Bean
	public DocumentConverter jodConverter(OfficeManager officeManager) {
		return LocalConverter.make(officeManager);
	}

}
