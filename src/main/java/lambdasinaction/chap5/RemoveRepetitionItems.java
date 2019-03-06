package lambdasinaction.chap5;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author pengzhe
 * @date 2019-03-06 15:00
 */
public class RemoveRepetitionItems {

    public static void main(String[] args) {

        Map<String, String> hotDealItem1 = new HashMap<>();
        hotDealItem1.put("itemId", "123");
        hotDealItem1.put("moduleName", "99bestsellermcp");

        Map<String, String> hotDealItem2 = new HashMap<>();
        hotDealItem2.put("id", "1");
        hotDealItem2.put("itemId", "categorygroup2");
        hotDealItem2.put("moduleName", "categorygroup");

        Map<String, String> hotDealItem3 = new HashMap<>();
        hotDealItem3.put("id", "2");
        hotDealItem3.put("itemId", "categorygroup3");
        hotDealItem3.put("moduleName", "categorygroup");

        Map<String, String> hotDealItem4 = new HashMap<>();
        hotDealItem4.put("id", "3");
        hotDealItem4.put("itemId", "categorygroup4");
        hotDealItem4.put("moduleName", "categorygroup");

        Map<String, String> hotDealItem5 = new HashMap<>();
        hotDealItem5.put("id", "4");
        hotDealItem5.put("itemId", "categorygroup5");
        hotDealItem5.put("moduleName", "categorygroup");

        List<Map<String, String>> hotDealDatas = new ArrayList<>();
        hotDealDatas.add(hotDealItem1);
        hotDealDatas.add(hotDealItem2);
        hotDealDatas.add(hotDealItem3);
        hotDealDatas.add(hotDealItem4);
        hotDealDatas.add(hotDealItem5);

        Map<String, Object> hotDealFields = new HashMap<>();
        hotDealFields.put("datas", hotDealDatas);
        Map<String, Object> hotDealSection = new HashMap<>();
        hotDealSection.put("fields", hotDealFields);
        hotDealSection.put("moduleId", "hotDeals");
        hotDealSection.put("type", "data");

        List<Map<String, Object>> sections = new ArrayList<>();
        sections.add(hotDealSection);


        Map<String, String> gameCardItem1 = new HashMap<>();
        gameCardItem1.put("itemId", "6666");
        List<Map<String, String>> gameCardDatas = new ArrayList<>();
        gameCardDatas.add(gameCardItem1);
        Map<String, Object> gameCardFields = new HashMap<>();
        gameCardFields.put("datas", gameCardDatas);
        Map<String, Object> gameCardSection = new HashMap<>();
        gameCardSection.put("fields", gameCardFields);
        gameCardSection.put("moduleId", "gameCard");
        gameCardSection.put("type", "data");
        // sections.add(gameCardSection);

        checkHotDealsItemNumbers(sections, "categorygroup", "hotDeals");

        System.out.println(sections);

        /*List<String> hotDeals = getItemIds(sections, "hotDeals");

        List<String> gameCard = getItemIds(sections, "gameCard");*/

    }

    private static List<String> getItemIds(List<Map<String, Object>> sections, String moduleId) {
        Optional<List<String>> strings = sections.stream().filter(section -> moduleId.equalsIgnoreCase
                (section.getOrDefault("moduleId", "").toString()) &&
                "data".equalsIgnoreCase(section.getOrDefault("type", "").toString()))
                .findFirst().map(section -> {
                    Map<String, Object> fields = (Map<String, Object>) section.getOrDefault("fields", new HashMap<>());
                    List<Map<String, String>> datas = (List<Map<String, String>>) fields.getOrDefault("datas", new ArrayList<>());
                    Stream<String> itemId = datas.stream().map(data -> data.getOrDefault("itemId", "123"));
                    return itemId.collect(toList());
                });
        return strings.get();
    }

    private static void checkHotDealsItemNumbers(List<Map<String, Object>> sections, String checkName, String moduleId) {
        sections.stream().filter(section -> moduleId.equalsIgnoreCase
                (section.getOrDefault("moduleId", "").toString()) &&
                "data".equalsIgnoreCase(section.getOrDefault("type", "").toString()))
                .findFirst().map(section -> {
            Map<String, Object> fields = (Map<String, Object>) section.getOrDefault("fields", new HashMap<>());
            List<Map<String, String>> datas = (List<Map<String, String>>) fields.getOrDefault("datas", new ArrayList<>());
            long moduleNam = datas.stream().filter(data ->
                    data.getOrDefault("moduleName", "")
                            .equalsIgnoreCase(checkName)).count();
            datas.removeIf(data -> Integer.parseInt(data.getOrDefault("id", "1")) > 3);
            return sections;
        });

    }

    private static void remove(List<Map<String, Object>> sections, String gameCardMoudleId,
                               String hotDealsMoudleId) {

        Optional<List<Map<String, String>>> gameCardDatas = sections.stream().filter(section -> gameCardMoudleId.equalsIgnoreCase
                (section.getOrDefault("moduleId", "").toString()) &&
                "data".equalsIgnoreCase(section.getOrDefault("type", "").toString()))
                .findFirst().map(section -> {
                    Map<String, Object> fields = (Map<String, Object>) section.getOrDefault("fields", new HashMap<>());
                    return (List<Map<String, String>>) fields.getOrDefault("datas", new ArrayList<>());
                });

        Optional<List<Map<String, String>>> hotDealsDatas = sections.stream().filter(section -> gameCardMoudleId.equalsIgnoreCase
                (section.getOrDefault("moduleId", "").toString()) &&
                "data".equalsIgnoreCase(section.getOrDefault("type", "").toString()))
                .findFirst().map(section -> {
                    Map<String, Object> fields = (Map<String, Object>) section.getOrDefault("fields", new HashMap<>());
                    return (List<Map<String, String>>) fields.getOrDefault("datas", new ArrayList<>());
                });
        List<Map<String, String>> gameCard = gameCardDatas.get();

        List<Map<String, String>> hotDeals = hotDealsDatas.get();


    }
}
