package proj.lak.userAuth.Test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LAKSHMI
 */

@RestController
public class TokenAuthenticationTestController {
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Hello World!";
        
	}

}
