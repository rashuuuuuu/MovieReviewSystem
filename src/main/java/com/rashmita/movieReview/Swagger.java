package com.rashmita.movieReview;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@OpenAPIDefinition(info = @Info(title="movieReview",
        description = "this api is for user information",
        summary="api contains movie info",
        termsOfService = "term and condition"
),
security= @SecurityRequirement(name = "movieReview")
)
@SecurityScheme(
        name="movieReview",
        in= SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme= "Bearer")
public class Swagger {

}
