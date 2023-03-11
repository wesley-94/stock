# 주식 종목 정보 서비스

## 0. 메인 화면
<img width="494" alt="메인 화면" src="https://user-images.githubusercontent.com/56331160/219951104-0fb77688-0a9a-415a-9cd9-c4aa6d5d9d64.png">

## 1. 프로젝트 소개
### 프로젝트 개요 및 동기
인프런에서 김영한 님의 강의 및 이동욱 님의 책을 통해 Spring 및 JPA 에 대해 학습한 후  
이를 정리하고 체득하기 위해 수행한 프로젝트 입니다.
- 김영한 님의 강의 수강 목록
  > [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8)  
  > [스프링 핵심 원리 - 기본편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)  
  > [스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1)  
  > [스프링 MVC 2편 - 백엔드 웹 개발 활용 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-2)  
  > [스프링 핵심 원리 - 고급편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B3%A0%EA%B8%89%ED%8E%B8)  
  > [스프링 DB 1편 - 데이터 접근 핵심 원리](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-db-1)  
  > [자바 ORM 표준 JPA 프로그래밍 - 기본편](https://www.inflearn.com/course/ORM-JPA-Basic)  
  > [실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1)  
  > [실전! 스프링 부트와 JPA 활용2 - API 개발과 성능 최적화](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-API%EA%B0%9C%EB%B0%9C-%EC%84%B1%EB%8A%A5%EC%B5%9C%EC%A0%81%ED%99%94)  
  > [실전! 스프링 데이터 JPA](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0-JPA-%EC%8B%A4%EC%A0%84)  
  > [실전! Querydsl](https://www.inflearn.com/course/querydsl-%EC%8B%A4%EC%A0%84)  
  > [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC)  
- 이동욱 님의 책
  > [스프링 부트와 AWS로 혼자 구현하는 웹 서비스](http://www.yes24.com/Product/Goods/83849117)  
  
## 2. 기술 스택  
|Vue.js|Spring Boot MVC|JPA|Spring Data JPA|Query DSL|MySQL|
|------|---------------|---|---------------|---------|-----|  
|![vue](https://user-images.githubusercontent.com/56331160/218122343-5fb98241-f4f1-485b-870a-1c5bd123de8b.png)|![Spring-Boot-MVC-2](https://user-images.githubusercontent.com/56331160/209467801-27dd0e0b-cbd9-4103-9d89-8e9ff46957c7.png)|![jpa](https://user-images.githubusercontent.com/56331160/209467730-f97deff0-b4f9-4ed6-9d25-f8a65262000b.png)|![springdatajpa](https://user-images.githubusercontent.com/56331160/209467739-b4c9f7c6-297e-4f72-86df-ec57ed369dae.png)|![dsl](https://user-images.githubusercontent.com/56331160/209467772-c5c50c1b-77af-4797-89e7-35a969e848b1.png)|![mysql](https://user-images.githubusercontent.com/56331160/218122432-918086e1-6e9e-4cc7-aa18-5a31bf593477.png)|

## 3. 구현 기능
1. Front-End
    - Modal
2. Back-End
    - CRUD
    - Paging
    - Spring Security OAuth2 

## 4. 배운 점 & 아쉬운 점
### 배운 점
1. Migration 작업
    - Front-End
        - UI
            - From Mustache.js to Vue.js
    - Back-End
        - DB
            - From H2 Database to MySQL
### 아쉬운 점
1. 구현 기능의 범위를 좁힌 상태 (향후 확장 예정)
   - 데이터 조회 시 Entity 를 그대로 노출하는 문제 존재
      - Entity 대신 DTO 를 사용하도록 변경 필요
2. 테스트 코드 작성 미흡

## 5. 문제 발생 및 해결 이력 
1. Axios 통신 시 CORS 문제 발생 [해결 완료]
   - vue.config.js 파일에서, proxy 설정
   - WebConfig 파일에서, addCorsMappings(CorsRegistry registry) 함수 추가
