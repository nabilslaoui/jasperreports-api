package fr.nabilslaoui.enterprise.composition.boostrap.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.http.HttpMethod;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import fr.nabilslaoui.enterprise.commun.api.config.AuthentificationM2MConfigurer;

@Configuration
@ComponentScan(basePackages = { "fr.nabilslaoui.enterprise.composition.adapters.rest.controllers",
		"fr.nabilslaoui.enterprise.composition.services", "fr.nabilslaoui.enterprise.commun.api.filters",
		"fr.nabilslaoui.enterprise.commun.web.controllers", "fr.nabilslaoui.enterprise.commun.util",
		"fr.nabilslaoui.enterprise.commun.monitoring", "fr.nabilslaoui.enterprise.commun.config",
		"fr.nabilslaoui.enterprise.commun.services", "fr.nabilslaoui.enterprise.commun.api.config" })
public class WebConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthentificationM2MConfigurer authentificationM2MConfig;

	@Bean
	public LinkDiscoverers discoverers() {
		final List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable()
				.authorizeRequests()
				// No need authentication.
				.antMatchers(HttpMethod.POST, "/*/composition/**").permitAll();
		authentificationM2MConfig.configure(http, authenticationManager());
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		authentificationM2MConfig.configureUser(auth);
	}

}
