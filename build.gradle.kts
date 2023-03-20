plugins {
	java
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"

}

group = "com.Woo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.chiknrice:concordion-spring-runner:1.0.0")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot:3.0.1")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	//PostgreSQL 드라이버 추가
	runtimeOnly("org.postgresql:postgresql")

	compileOnly ("org.projectlombok:lombok")
	annotationProcessor ("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation(group = "org.apache.httpcomponents", name= "httpclient", version= "4.5.13")

	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("net.nurigo:javaSDK:2.2")
	implementation("javax.mail:mail:1.4.7")
	implementation("org.springframework:spring-context-support:5.2.3.RELEASE")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
