package abramov.instagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NonMutualResult {
    @JsonProperty("not_following_back")
    private List<String> notFollowingBack;

    @JsonProperty("not_followed_by_you")
    private List<String> notFollowedByYou;

    public NonMutualResult() {
    }

    public NonMutualResult(List<String> notFollowingBack, List<String> notFollowedByYou) {
        this.notFollowingBack = notFollowingBack;
        this.notFollowedByYou = notFollowedByYou;
    }

    public List<String> getNotFollowingBack() {
        return notFollowingBack;
    }

    public void setNotFollowingBack(List<String> notFollowingBack) {
        this.notFollowingBack = notFollowingBack;
    }

    public List<String> getNotFollowedByYou() {
        return notFollowedByYou;
    }

    public void setNotFollowedByYou(List<String> notFollowedByYou) {
        this.notFollowedByYou = notFollowedByYou;
    }
}
