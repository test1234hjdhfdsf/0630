import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf(csrf ->
        // BAD - CSRF protection shouldn't be disabled
        csrf.disable() 
      );
  }

  public void evaluate(Socket socket) throws IOException {
  try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream()))) {
    
    String input = reader.readLine();
    JexlEngine jexl = new JexlBuilder().create();
    // BAD: input is controlled by the user
    JexlExpression expression = jexl.createExpression(input);
    JexlContext context = new MapContext();
    expression.evaluate(context);
  }
}
}
