package fr.nabilslaoui.enterprise.composition.adapters.rest.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.nabilslaoui.enterprise.commun.bo.Result;
import fr.nabilslaoui.enterprise.composition.domain.enums.TypeDocumentComposition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/v1/composition", produces = { MediaType.APPLICATION_JSON_VALUE })
@RequiredArgsConstructor
public class CompositionController {

	//private final CompositionService compositionService;

	@PreAuthorize("estProfilUser(#request) || estBatch(#request)")
	@ApiOperation(value = "Génération document pdf avec Jasper")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Données invalides"),
			@ApiResponse(code = 404, message = "Pas de document correspondant"),
			@ApiResponse(code = 500, message = "Erreur interne") })
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	@PostMapping("/{typeDocument}/{version}")
	public Result<String> compositionDocument(@RequestBody final String compositionDocument,
			@PathVariable final TypeDocumentComposition typeDocument, @PathVariable final String version, final HttpServletRequest request) {

		//return new Result<>(compositionService.composeDocument(compositionDocument, typeDocument, version, RecuperationHeaderUtils.getIdArobasFromHttpRequete(request)));
		return null;
	}
}
