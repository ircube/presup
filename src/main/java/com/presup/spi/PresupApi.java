package com.presup.spi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.presup.Constants;
import com.presup.form.ProfileForm;
import com.presup.kind.Profile;
import com.presup.kind.UserPresup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static com.presup.service.OfyService.ofy;


/**
 * Defines Presup APIs.
 */
@Api(name = "presupEndpoints", version = "v1",
        scopes = { Constants.EMAIL_SCOPE },
        clientIds = {
        Constants.WEB_CLIENT_ID,
        Constants.API_EXPLORER_CLIENT_ID },
        description = "API for the Presup Backend application.")
public class PresupApi {
    /*
     * Get the display name from the user's email. For example, if the email is
     * lemoncake@example.com, then the display name becomes "lemoncake."
     */

    private static final Boolean True = null;
    private static final Boolean False = null;

    private static String extractDefaultDisplayNameFromEmail(String email) {
        return email == null ? null : email.substring(0, email.indexOf("@"));
    }


    @ApiMethod(name = "getProfile", path = "profile", httpMethod = HttpMethod.GET)
    public Profile getProfile(final User user) throws UnauthorizedException {
        if (user == null) {
            throw new UnauthorizedException("Authorization required");
        }

        String userId = user.getUserId();
        Key key = Key.create(Profile.class, userId);
        Profile profile = (Profile) ofy().load().key(key).now();
        return profile;
    }

    @ApiMethod(name = "getByName", path = "byName", httpMethod = HttpMethod.GET )
    public UserPresup getByName( @Named("yourName") String name ) throws UnsupportedEncodingException {
        System.out.println("name: "+name);

        String newString = new String(name.getBytes("UTF-8"), "UTF-8");

        System.out.println("newString: "+newString);

        if (name == null || name == "" ){
            name ="error";
            throw new NullPointerException("nombre vacio") ;
        }else{
            Key key = Key.create(Profile.class, name);
            Profile profile = (Profile) ofy().load().key(key).now();
        }

        return new UserPresup(name);
    }


    @ApiMethod(name = "saveProfile", path = "saveProfile", httpMethod = HttpMethod.POST )
    public Profile  saveProfile ( final User user, ProfileForm profileForm ) throws UnauthorizedException {
        String mail;
        String userId;
        if ( user == null ){
            throw new UnauthorizedException("autorizacion requerida");
        }
        mail = user.getEmail();
        userId = user.getUserId();
        if ( profileForm.getDisplayName()== null ){

        }
        return new Profile( userId,mail );

    }
}
