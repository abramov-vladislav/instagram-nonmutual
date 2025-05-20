package abramov.instagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NonMutualResult {
    @JsonProperty("not_following_back")
    private List<ValueData> notFollowingBack;

    @JsonProperty("not_followed_by_you")
    private List<ValueData> notFollowedByYou;

    public NonMutualResult() {
    }

    public NonMutualResult(List<ValueData> notFollowingBack, List<ValueData> notFollowedByYou) {
        this.notFollowingBack = notFollowingBack;
        this.notFollowedByYou = notFollowedByYou;
    }

    public List<ValueData> getNotFollowingBack() {
        return notFollowingBack;
    }

    public void setNotFollowingBack(List<ValueData> notFollowingBack) {
        this.notFollowingBack = notFollowingBack;
    }

    public List<ValueData> getNotFollowedByYou() {
        return notFollowedByYou;
    }

    public void setNotFollowedByYou(List<ValueData> notFollowedByYou) {
        this.notFollowedByYou = notFollowedByYou;
    }
}

