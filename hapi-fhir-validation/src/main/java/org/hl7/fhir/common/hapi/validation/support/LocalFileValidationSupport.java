package org.hl7.fhir.common.hapi.validation.support;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.IValidationSupport;
import ca.uhn.fhir.i18n.Msg;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class LocalFileValidationSupport extends PrePopulatedValidationSupport {



	public LocalFileValidationSupport(FhirContext ctx) {
		super(ctx);
	}

	@Override
	public FhirContext getFhirContext() {
		return myCtx;
	}

	public void loadFile(String theFileName) throws IOException {
		String contents = IOUtils.toString(new InputStreamReader(new FileInputStream(theFileName), "UTF-8"));
		IBaseResource resource  = myCtx.newJsonParser().parseResource(contents);
		this.addStructureDefinition(resource);
	}

}
