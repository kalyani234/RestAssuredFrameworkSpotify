package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.Playlistapi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;

import static com.spotify.oauth2.utils.FakerUtils.getDescription;
import static com.spotify.oauth2.utils.FakerUtils.getName;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Epic("Spotify 2.0 Auth")
@Feature("Automate the Playlist API")
public class PlaylistsTests extends BaseTest{


    //Requestplaylist
    @Step
    public Playlist playlistBuilder(String name, String description, boolean _public) {

        //lombok builder

        return  Playlist.builder().
                name(name).
                description(description).
                _public(_public).build();
//        Playlist playlist = new Playlist();
//        playlist.setName(name);
//        playlist.setDescription(description);
//        playlist.set_public(_public);
//       return playlist;
//        return new Playlist().setName(name).setDescription(description).setPublic(_public);

    }

    //AssertionOptimizeCode
    @Step
    public void assertPlaylistEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(), equalTo(requestPlaylist.get_public()));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step
    public void assertErrorResponse(Error responseError, StatusCode statusCode) {
        assertThat(responseError.getError().getStatus(), equalTo(statusCode.code));
        assertThat(responseError.getError().getMessage(), equalTo(statusCode.msg));
    }



    @Story("Create a Playlist")
    @Test(description = "To create a playlist")
    public void create_playlist() {

        Playlist requestPlaylist = playlistBuilder(getName(), getDescription(), false);
        Response response = Playlistapi.post(requestPlaylist);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.code201);

//        Playlist requestPlaylist = new Playlist().
//                setName("New Playlist20").setDescription("New playlist20 description").setPublic(false);
//        requestPlaylist.setName("New Playlist4");
//        requestPlaylist.setDescription("New playlist3 description");
//        requestPlaylist.setPublic(false);

//        String payload= "{\n" +
//                "    \"name\": \"New Playlist3\",\n" +
//                "    \"description\": \"New playlist3 description\",\n" +
//                "    \"public\": false\n" +
//                "}";
//        Playlist responsePlaylist = response.as(Playlist.class);

//        Playlist responsePlaylist = given(getRequestSpec()).
//                body(requestPlaylist).
//                when().
//                post("users/31oo77dq4qard6ovzfjmebohfeim/playlists").
//                then().spec(getResponseSpec()).assertThat().statusCode(201).
//                extract().response().as(Playlist.class);
//        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
//        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
//        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
//                 body("name",equalTo("New Playlist3"),"description", equalTo("New playlist3 description"),"public",equalTo(false));
    }


    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @TmsLink("test-1")
    @Description("This API is to get a playlist")
    @Test (description = "Get a playlist")
    public void get_playlist() {

        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name", "Updated playlist description", false);
        Response response = Playlistapi.get(DataLoader.getInstance().getPlaylistId());
        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.code200);
        //  Playlist requestPlaylist = new Playlist().setName("Updated Playlist Name").setDescription("Updated playlist description").setPublic(false);

//        Playlist responsePlaylist = response.as(Playlist.class);

//        Playlist responsePlaylist = given(getRequestSpec()).
//                when().get("/playlists/51HyhPpG3cJ5WnalbEf5Cs").then()
//                .spec(getResponseSpec()).assertThat().statusCode(200)
//                .extract().response().as(Playlist.class);
//                body("name", equalTo("New Playlist3"), "description", equalTo("New playlist3 description"), "public", equalTo(false));
//        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
//        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
//        assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
    }

    @Test (description = "Update old playlist")
    public void update_playlist() {

        Playlist requestPlaylist = playlistBuilder("Updated Playlist6", "Updated playlist6 description", false);
        Response response = Playlistapi.put(DataLoader.getInstance().updatePlayListId(), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.code200);

        //  Playlist requestPlaylist = new Playlist().setName("Updated Playlist6").setDescription("Updated playlist6 description").setPublic(false);


//        String payload = "{\n" +
//                "    \"name\": \"Updated Playlist Name\",\n" +
//                "    \"description\": \"Updated playlist description\",\n" +
//                "    \"public\": false\n" +
//                "}";



//        assertThat(response.getStatusCode(), equalTo(200));
//        given(getRequestSpec()).
//                body(requestPlaylist).
//                when().
//                put("/playlists/39N7Q3TWMYfJMWuUB1DogO").
//                then().spec(getResponseSpec()).assertThat().statusCode(200);
    }

    @Story("Create a Playlist")
    @Test(description = "Create playlist without Name")
    public void create_playlist_withoutName() {

        Playlist requestPlaylist = playlistBuilder("", getDescription(), false);
        Response response = Playlistapi.post(requestPlaylist);
        assertErrorResponse(response.as(Error.class), StatusCode.code400);

//        Playlist requestPlaylist = new Playlist().setName("").setDescription("New playlist3 description").setPublic(false);

//        String payload= "{\n" +
//                "    \"name\": \"New Playlist3\",\n" +
//                "    \"description\": \"New playlist3 description\",\n" +
//                "    \"public\": false\n" +
//                "}";

        // Error responseError = response.as(Error.class);

//        Error responseError = given(getRequestSpec()).
//                body(requestPlaylist).
//                when().
//                post("users/31oo77dq4qard6ovzfjmebohfeim/playlists").
//                then().spec(getResponseSpec()).extract().response().as(Error.class);


//        assertThat(responseError.getError().getStatus(), equalTo(400));
//        assertThat(responseError.getError().getMessage(), equalTo("Missing required field: name"));

//                 body("name",equalTo("New Playlist3"),"description", equalTo("New playlist3 description"),"public",equalTo(false));
    }

    @Story("Create a Playlist")
    @Test(description = "Negative Testcase Create playlist with invalid Token")
    public void negative_create_playlist_invalidToken() {
        String invalid_token = "12345";
       Playlist requestPlaylist = playlistBuilder(getName(),getDescription(),false);
//        Playlist requestPlaylist = new Playlist();
//        requestPlaylist.setName("New Playlist");
//        requestPlaylist.setDescription("Updated playlist6 description");
//        requestPlaylist.set_public(false);

     //   Playlist requestPlaylist = new Playlist().setName("New Playlist").setDescription("Updated playlist6 description").setPublic(false);
        Response response = Playlistapi.post(invalid_token, requestPlaylist);
        assertErrorResponse(response.as(Error.class),StatusCode.code401);

//        String payload = "{\n" +
//                "    \"name\": \"New playlist4\",\n" +
//                "    \"description\": \"New playlist3 description\",\n" +
//                "    \"public\": false\n" +
//                "}";
        //   Error responseError = response.as(Error.class);

//        Error responseError = given().baseUri("https://api.spotify.com").
//                basePath("/v1").
//                header("Authorization", "Bearer " + "6456456").
//                contentType(ContentType.JSON).log().all().
//                body(requestPlaylist).
//                when().
//                post("users/31oo77dq4qard6ovzfjmebohfeim/playlists").
//                then().spec(getResponseSpec()).extract().response().as(Error.class);
//        assertThat(responseError.getError().getStatus(), equalTo(401));
//        assertThat(responseError.getError().getMessage(), equalTo("Invalid access token"));
        // body("error.status", equalTo(401), "error.message", equalTo("Invalid access token"));
    }


}