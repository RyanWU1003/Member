package tw.iii.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

public class WebSecurityConfig extends AbstractSecurityWebApplicationInitializer {

//	@Override
//	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
//		
//		super.afterSpringSecurityFilterChain(servletContext);
//	}

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}

}
