package ru.buttonone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
public class Chapter {

    @JsonProperty("_id")
    private String id;
    private String chapterName;

    public Chapter(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(chapterName, chapter.chapterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterName);
    }
}
