package abramov.instagram.service;

import abramov.instagram.model.InstagramData;
import abramov.instagram.model.NonMutualResult;
import abramov.instagram.model.ValueData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InstagramService {
    private final ObjectMapper mapper = new ObjectMapper();

    public NonMutualResult findNonMutual(MultipartFile followersFile,
                                         MultipartFile followingFile) throws IOException {
        List<InstagramData> followersList = extractDataList(followersFile);
        List<InstagramData> followingList = extractDataList(followingFile);

        Set<String> followers = extractNames(followersList);
        Set<String> following = extractNames(followingList);

        List<ValueData> notFollowingBack = following.stream()
                .filter(u -> !followers.contains(u))
                .map(ValueData::new)
                .collect(Collectors.toList());

        List<ValueData> notFollowedByYou = followers.stream()
                .filter(u -> !following.contains(u))
                .map(ValueData::new)
                .collect(Collectors.toList());

        return new NonMutualResult(notFollowingBack, notFollowedByYou);
    }

    // Ищет первый JSON‑массив внутри корня и конвертирует его в List<InstagramData>
    private List<InstagramData> extractDataList(MultipartFile file) throws IOException {
        JsonNode root = mapper.readTree(file.getInputStream());
        JsonNode arrayNode = null;

        if (root.isArray()) {
            arrayNode = root;
        } else if (root.isObject()) {
            // перебираем все поля объекта и берём первый массив
            Iterator<JsonNode> elems = root.elements();
            while (elems.hasNext()) {
                JsonNode n = elems.next();
                if (n.isArray()) {
                    arrayNode = n;
                    break;
                }
            }
        }

        if (arrayNode == null) {
            throw new IOException("Не найден JSON-массив в файле: " + file.getOriginalFilename());
        }

        // конвертируем найденный массив в List<InstagramData>
        return mapper.convertValue(arrayNode, new TypeReference<List<InstagramData>>() {
        });
    }

    // Вспомогательный метод для извлечения поля 'value'
    private Set<String> extractNames(List<InstagramData> list) {
        return list.stream()
                .flatMap(d -> d.getStringListData().stream())
                .map(ValueData::getValue)
                .collect(Collectors.toSet());
    }
}
