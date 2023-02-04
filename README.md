# 주식 종목 정보 서비스

## 0. 메인 화면
<img width="494" alt="메인 화면" src="https://user-images.githubusercontent.com/56331160/209466622-04c4abce-210a-4b19-bdb9-78493daf2ded.png">

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
|Spring Boot MVC|JPA|Spring Data JPA|Query DSL|
|--------------|---|---------------|---------|  
|![Spring-Boot-MVC-2](https://user-images.githubusercontent.com/56331160/209467801-27dd0e0b-cbd9-4103-9d89-8e9ff46957c7.png)|![jpa](https://user-images.githubusercontent.com/56331160/209467730-f97deff0-b4f9-4ed6-9d25-f8a65262000b.png)|![springdatajpa](https://user-images.githubusercontent.com/56331160/209467739-b4c9f7c6-297e-4f72-86df-ec57ed369dae.png)|![dsl](https://user-images.githubusercontent.com/56331160/209467772-c5c50c1b-77af-4797-89e7-35a969e848b1.png)|

## 3. 구현 기능
### 기능 1

## 4. 배운 점 & 아쉬운 점
### 배운 점
### 아쉬운 점

## 5. 문제 발생 및 해결 이력 
(해결 완료 상태는 밑줄로 표시)
### @ 2022년 12월 23일
  > 1) "회원 가입" 후 "회원 목록"에서 조회를 할 때 데이터가 사라져 있음 (정상적으로 저장 불가 상태)  
  > 2) "주식 등록" 화면에서 정보를 입력하고 "등록 완료" 버튼을 클릭 (저장)을 하려고 하면 정상적으로 되지 않음  
  > 3) "주식 목록" 화면에서 "메인 페이지로 이동" 버튼이 없음  
  > 4) DB에 저장 가능한지 확인 핊요