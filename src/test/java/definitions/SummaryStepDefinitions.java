package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SummaryStepDefinitions {
    RequestSpecification requestSpec;
    Response response;

    public SummaryStepDefinitions() {
        requestSpec = RestAssured.given()
            .baseUri("https://status.digitalocean.com")
            .basePath("/api/v2");
    }

    @Given("I set content type to Json")
    public void iSetContentTypeToJson() {
        requestSpec.contentType(ContentType.JSON);
    }

    @When("I send a GET request to summary method")
    public void iSendGetRequestToSummary() {
        response = requestSpec.get("/summary.json");
        var page = JsonPath.read(response.getBody().asString(), "$.page");
        System.out.println(page);
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("component keys should be present")
    public void componentKeysArePresent() {
        String path = "$.components[*].keys()";
        ArrayList<Set<String>> keysInComponents = JsonPath.read(response.getBody().asString(), path);
        for (Set<String> componentKeys : keysInComponents) {
            assertThat(componentKeys, anyOf(hasSize(13), hasSize(14)));
            assertThat(componentKeys, hasItem(is("name")));
            assertThat(componentKeys, hasItem(is("status")));
            assertThat(componentKeys, hasItem(is("created_at")));
            assertThat(componentKeys, hasItem(is("updated_at")));
            assertThat(componentKeys, hasItem(is("position")));
            assertThat(componentKeys, hasItem(is("description")));
            assertThat(componentKeys, hasItem(is("showcase")));
            assertThat(componentKeys, hasItem(is("start_date")));
            assertThat(componentKeys, hasItem(is("group_id")));
            assertThat(componentKeys, hasItem(is("page_id")));
            assertThat(componentKeys, hasItem(is("group")));
            assertThat(componentKeys, hasItem(is("only_show_if_degraded")));
        }
    }

    @Then("component values are the correct format")
    public void componentValuesAreCorrect() {
        String path = "$.components";
        ArrayList<LinkedHashMap> components = JsonPath.read(response.getBody().asString(), path);
        for (LinkedHashMap component : components) {
            assertThat(component.get("name"), isA(String.class));
            assertThat(component.get("status"), isA(String.class));
            assertThat(component.get("created_at"), isA(String.class));
            assertThat(component.get("updated_at"), isA(String.class));
            assertThat(component.get("position"), isA(Integer.class));
            assertThat(component.get("description"), is(nullValue()));
            assertThat(component.get("showcase"), isA(Boolean.class));
            assertThat(component.get("start_date"), anyOf(isA(String.class), is(nullValue())));
            assertThat(component.get("group_id"), anyOf(isA(String.class), is(nullValue())));
            assertThat(component.get("page_id"), isA(String.class));
            assertThat(component.get("group"), isA(Boolean.class));
            assertThat(component.get("only_show_if_degraded"), isA(Boolean.class));
            assertThat(component.get("group_id"), anyOf(isA(String.class), isA(JSONArray.class), is(nullValue())));
        }
    }

    @Then("component statuses should be operational")
    public void componentsShouldBeOperational() {
        String path = "$.components[*].status";
        JSONArray statuses = JsonPath.read(response.getBody().asString(), path);
        for (Object status : statuses) {
            Assert.assertEquals(status, "operational");
        }
    }
}