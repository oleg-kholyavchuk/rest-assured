package ru.buttonone.lotr;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.collections.Lists;
import ru.buttonone.model.Book;
import ru.buttonone.model.Chapter;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("API Властелина колец")
public class LotrTest {

    public static final String LORT_API_URL = "https://the-one-api.dev/v2";
    public static final String LORT_API_URN = "/book/5cf58077b53e011a64671583/chapter";

    @DisplayName("Корректно получить книги")
    @Test
    public void shouldHaveCorrectGetBook() {

        ValidatableResponse validatableResponse = given()
                .baseUri(LORT_API_URL)
                .when()
                .get("/book")
                .then()
                .statusCode(200);

        List<Book> bookList = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getList("docs", Book.class);

        System.out.println("bookList = " + bookList);

//        Assertions.assertAll(
//                () -> assertTrue((bookList.stream().anyMatch(b -> b.getName()
//                        .equals("The Fellowship Of The Ring")))),
//                () -> assertTrue((bookList.stream().anyMatch(b -> b.getName()
//                        .equals("The Two Towers")))),
//                () -> assertTrue((bookList.stream().anyMatch(b -> b.getName()
//                        .equals("The Return Of The King"))))
//        );

//        assertThat(bookList, Matchers.hasItem(new Book("The Fellowship Of The Ring")));

        List<Book> collection = Lists.newArrayList(
                new Book("5cf5805fb53e011a64671582", "The Fellowship Of The Ring"),
                new Book("5cf58077b53e011a64671583", "The Two Towers"),
                new Book("5cf58080b53e011a64671584", "The Return Of The King"));

        assertThat(bookList, is(containsInAnyOrder(
                collection
//                new Book("The Fellowship Of The Ring"),
//                new Book("The Two Towers"),
//                new Book("The Return Of The King")
        )));

//                .log().all()
//                .statusCode(200);

    }

    @DisplayName("Корректно получить главы")
    @Test
    public void shouldHaveCorrectGetChapter() {


        ValidatableResponse validatableResponse = given()
                .baseUri(LORT_API_URL)
                .when()
                .get(LORT_API_URN)
                .then()
                .statusCode(200);

        List<Chapter> chapterList = validatableResponse
                .extract()
                .body()
                .jsonPath()
                .getList("docs", Chapter.class);

        System.out.println("chapterList = " + chapterList);

        assertThat(chapterList, Matchers.containsInAnyOrder(
                new Chapter("The Departure of Boromir"),
                new Chapter("The Riders of Rohan"),
                new Chapter("The Uruk-Hai"),
                new Chapter("Treebeard"),
                new Chapter("The White Rider"),
                new Chapter("The King of the Golden Hall"),
                new Chapter("Helm's Deep"),
                new Chapter("The Road to Isengard"),
                new Chapter("Flotsam and Jetsam"),
                new Chapter("The Voice of Saruman"),
                new Chapter("The Palantir"),
                new Chapter("The Taming of Smeagol"),
                new Chapter("The Passage of the Marshes"),
                new Chapter("The Black Gate is Closed"),
                new Chapter("Of Herbs and Stewed Rabbit"),
                new Chapter("The Window on the West"),
                new Chapter("The Forbidden Pool"),
                new Chapter("Journey to the Cross-roads"),
                new Chapter("The Stairs of Cirith Ungol"),
                new Chapter("Shelob's Lair"),
                new Chapter("The Choices of Master Samwise")
        ));
    }
}
