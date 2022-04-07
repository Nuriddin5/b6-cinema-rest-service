package uz.pdp.b6cinemarestservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import uz.pdp.b6cinemarestservice.model.User;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("login")
    public String getLoginPage(Model model) {

        String authorizationRequestBaseUri = "oauth2/authorization";

        Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

        Iterable<ClientRegistration> clientRegistrations = null;

        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);


        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {

            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(), //name
                        authorizationRequestBaseUri + "/" + registration.getRegistrationId() // url
                ));
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "login";
    }


    @GetMapping("success")
    public String getSuccessPage(Model model, UsernamePasswordAuthenticationToken authentication) {
        User user = (User) authentication.getPrincipal();

        model.addAttribute("name", user.getFullName());
        return "success-page";
    }

    @GetMapping("success-oauth2")
    public String getSuccessPage(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());


        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUri();

        if (!StringUtils.isEmpty(userInfoEndpointUri)) {

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());

            HttpEntity entity = new HttpEntity("", headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    userInfoEndpointUri,
                    HttpMethod.GET,
                    entity,
                    Map.class);

            Map userAttributes = response.getBody(); // user ma'lumotlari

            // TODO: 4/7/2022 save user to db



            model.addAttribute("name", userAttributes.get("name"));
            model.addAttribute("imgUrl", userAttributes.get("picture"));
            model.addAttribute("email", userAttributes.get("email"));

        }
        return "success-page";
    }

    @GetMapping("failed")
    public String getFailedPage() {
        return "failed";
    }
}
