package proj.lak.userAuth.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import proj.lak.userAuth.util.JwtUtil;
/**
 * @author LAKSHMI
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenAuthenticationServiceTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private JwtUtil jwtUtil;

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {
        String token = jwtUtil.generateToken("siri");
        System.out.println("----> " + token);

        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get("/test").header("Authorization", "Bearer "+ token)).andExpect(status().isOk());
    }
    
    @Test
    public void shouldNotGenerateAuthToken() throws Exception {
        String username = "lakshmi";
        String password = "123";

        String body = "{\"userName\":\"" + username + "\", \"password\":\"" + password + "\"}";

        mvc.perform(MockMvcRequestBuilders.post("/token")
                .content(body))
                .andExpect(status().isForbidden()).andReturn();
    }
   
}



