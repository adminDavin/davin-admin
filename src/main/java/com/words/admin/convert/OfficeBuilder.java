package com.words.admin.convert;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.LocalOfficeManager.Builder;
import org.jodconverter.office.OfficeManager;

import com.words.admin.config.Constant;

public class OfficeBuilder {
	private OfficeManager officeManager;
	private static OfficeBuilder officeBuilder;

	private OfficeBuilder() {
		super();
		Builder builder = LocalOfficeManager.builder();
		Set<Integer> iports = new HashSet<Integer>();
		iports.add(8100);
		iports.add(8101);
		iports.add(8102);
		iports.add(8103);
		iports.add(8104);
		iports.add(8105);
		iports.add(8106);
		iports.add(8107);
		builder.portNumbers(ArrayUtils.toPrimitive((Integer[]) iports.toArray(new Integer[iports.size()])));
		builder.officeHome(Constant.OFFICEHOME);
		builder.workingDir(Constant.OFFICEWORKER);
		builder.killExistingProcess(true);
		builder.processTimeout(120000L);
		builder.processRetryInterval(250L);
		builder.taskExecutionTimeout(120000L);
		builder.maxTasksPerProcess(200);
		builder.taskQueueTimeout(30000L);
		officeManager = builder.build();
	}

	public static OfficeManager builder() {
		if (officeBuilder == null) {
			return new OfficeBuilder().officeManager;
		}
		return officeBuilder.officeManager;
	}
}
