import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"

	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"

	// https://github.com/jlleitschuh/ktlint-gradle?tab=readme-ov-file#ktlint-gradle
	id("org.jlleitschuh.gradle.ktlint") version "12.1.0"

	// https://github.com/Kotlin/kotlinx-kover?tab=readme-ov-file#kover-gradle-plugin
	id("org.jetbrains.kotlinx.kover") version "0.7.6"
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.2.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.5")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
