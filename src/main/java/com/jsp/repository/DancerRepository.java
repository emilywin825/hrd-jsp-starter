package com.jsp.repository;

import com.jsp.entity.Dancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//DAO
//댄서 정보 저장소 -> data 관리 -> 서블릿 역활 대폭 축소시켜줌
public class DancerRepository {
    private final Map<String, Dancer> dancerMap=new HashMap<>();

    //댄서 저장 기능
// 댄서 저장 기능
    public void save(String name, String crewName,
                     String danceLevel, String[] genresArray) {
        // Dancer 객체로 포장
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

        List<Dancer.Genre> genres = new ArrayList<>();
        if (genresArray != null) {
            for (String g : genresArray) {
                genres.add(Dancer.Genre.valueOf(g));
            }
        }
        dancer.setGenres(genres);

        System.out.println("dancer = " + dancer);

        // dancerList에 저장
        dancerMap.put(name, dancer);
    }

    //댄서 맵을 리스트로 변환해서 리턴하는 메서드
    public List<Dancer> findAll(){
//아래 3개 중 골라쓰면 됨
        //가장 간단한 방법
        return new ArrayList<>(dancerMap.values());
        
//        return dancerMap.values().stream().collect(Collectors.toList());

/*        List<Dancer> dancerList=new ArrayList<>();
        for (Dancer dancer : dancerMap.values()) {
            dancerList.add(dancer);
        }
        return dancerList;*/
    }

}
