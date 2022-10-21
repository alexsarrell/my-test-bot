-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: test_bot
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `answer_id` bigint NOT NULL AUTO_INCREMENT,
  `answer_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'Fails compilation'),(2,'Creates a two-dimensional array'),(3,'Calls a function which is returned by the call foo'),(4,'JVM'),(5,'JavaScript'),(6,'.NET CLR'),(7,'LLVM'),(8,'It is Kotlin term for class methods'),(9,'These are func which accept other functions as argument'),(10,'They provide asyncronous code without thread blocking'),(11,'Automatically declared value based on the expected type'),(12,'An infix extension function to create a Pair(10, 15)'),(13,'A Kotlin keyword to create a Pair(10, 15)'),(14,'A Kotlin keyword to create an object copy'),(15,'A Kotlin keyword to create a range from 10 to 15'),(16,'A syntax error'),(17,'int i = 15'),(18,'var i : int = 15'),(19,'var i : Integer = 15'),(20,'var i : Int = 15'),(21,'let i = 15'),(22,'It is public'),(23,'It is private'),(24,'It has a private property id'),(25,'\"15\".toLong()'),(26,' Long.parseLong(\"15\")'),(27,'val l: Long = (Long)\"15\"'),(28,'Yes, but Kotlin internally always converts them to RDT'),(29,'Yes, Kotlin is similar to Java in this respect'),(30,'No, Kotlin does not have nor use primitive data types'),(31,'Not at language level, but the compiler uses primitives'),(32,'firstStr is final and cannot be changed'),(33,'secStr is final and cannot be changed'),(34,'firstStr can be null as opposed to secStr'),(35,'void message(String message)'),(46,'fun message(msg: String)'),(47,'fun void message(msg: String)'),(48,'It is the logical NOT operation, like ! in Java'),(49,'It compares two values for identity rather than equality'),(50,'It is the ternary operator like ? : in Java'),(51,'It converts value to a non-null type'),(52,'Array<String>'),(53,'String[]'),(54,'StringArray'),(55,'val x = a ?: b, c'),(56,'val x = a ? b : c'),(57,'val x = if(a) b else c'),(58,'class Helper{ static fun help() { println(I give you help\") }\"'),(59,'class Helper{ companion object {fun help() { println(I give you help\") } }\"'),(60,'MIT'),(61,'GPL'),(62,'Apache 2'),(63,'Calls the specified func block whit this object value as its argument and returns the result'),(64,'Returns the ASCII symbols letter value of object name'),(65,'[1, 16, 25]'),(66,'[25, 16, 1]'),(67,'[1, 2, 3, 2, 4, 6, 3, 6, 9]'),(68,'Variables declared with val are final, those with var are not'),(69,'Variables declared with var are final, those with val are not'),(70,'Variables declared with val can only access const members'),(71,'fun source(url: String, pass: String) : DataSource { return DataSource(url, pass) }'),(72,'fun source(url: String, pass: String) : DataSource =  DataSource(url, pass) '),(73,'fun source(url: String, pass: String) : DataSource ->  DataSource(url, pass) ');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `question_text` varchar(255) DEFAULT NULL,
  `answer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FK2w9qd6mx9oh2vchntaokhlj4f` (`answer_id`),
  CONSTRAINT `FK2w9qd6mx9oh2vchntaokhlj4f` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,NULL,'What does foo()() code do?',3),(2,NULL,'Which of these targets does Kotlin currently not support?',6),(3,NULL,'What are Kotlin coroutines?',10),(4,'https://www.dropbox.com/s/qtr5laol1jxuc3y/it_example.png?dl=0','What is \'it\' in the following example?',11),(5,'https://www.dropbox.com/s/1ymchjlke1p7wyf/to_example.png?dl=0','What is \'to\' in the example below?',12),(6,NULL,'What is the correct way to declare a variable of integer type in Kotlin?',20),(7,'https://www.dropbox.com/s/5ia3enesvrhplz9/simple_class.png?dl=0','Which is true for the following class declaration?',22),(8,NULL,'What is the correct syntax to convert the String \"42\" to a Long in Kotlin?',25),(9,NULL,'Does Kotlin have primitive data types, such as int, long, float?',31),(10,'https://www.dropbox.com/s/7yu54x71vy2xyyk/difference_between_strings.png?dl=0','What is difference between firstStr and secStr?',34),(11,NULL,'Which is valid function declaration in Kotlin?',46),(12,NULL,'What does the !! operator do?',51),(13,'https://www.dropbox.com/s/tihzr9luiygxuf5/array_type.png?dl=0','What is the type of arr in the following code?',52),(14,'https://www.dropbox.com/s/uyhy2dh9xsivrit/ternary.png?dl=0','What the following quivalent of the following Java expression in Kotlin?',57),(15,NULL,'What would be the Kotlin equivalent to a static method in Java?',59),(16,NULL,'Under which license is Kotlin available?',62),(17,NULL,'What does the .let function do?',63),(18,'https://www.dropbox.com/s/r6io1jxsrvmuir8/map.png?dl=0','What is the result of the following example?',65),(19,NULL,'What is the difference between val and var in Kotlin?',68),(20,NULL,'What is wrong function declaration in Kotlin?',73);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_answer`
--

DROP TABLE IF EXISTS `question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_answer` (
  `question_id` bigint NOT NULL,
  `answer_id` bigint NOT NULL,
  PRIMARY KEY (`question_id`,`answer_id`),
  KEY `FKil3pbbv488omhx2gkakco46yl` (`answer_id`),
  CONSTRAINT `FKflwcda2rengsndju5f1deywok` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  CONSTRAINT `FKil3pbbv488omhx2gkakco46yl` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_answer`
--

LOCK TABLES `question_answer` WRITE;
/*!40000 ALTER TABLE `question_answer` DISABLE KEYS */;
INSERT INTO `question_answer` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(2,7),(3,8),(3,9),(3,10),(3,11),(4,11),(5,12),(5,13),(4,14),(5,15),(4,16),(5,16),(6,17),(6,18),(6,19),(6,20),(6,21),(7,22),(7,23),(7,24),(8,25),(8,26),(8,27),(9,28),(9,29),(9,30),(9,31),(10,32),(10,33),(10,34),(11,35),(11,46),(11,47),(12,48),(12,49),(12,50),(12,51),(13,52),(13,53),(13,54),(14,55),(14,56),(14,57),(15,58),(15,59),(16,60),(16,61),(16,62),(17,63),(17,64),(18,65),(18,66),(18,67),(19,68),(19,69),(19,70),(20,71),(20,72),(20,73);
/*!40000 ALTER TABLE `question_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respondent`
--

DROP TABLE IF EXISTS `respondent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respondent` (
  `respondent_id` bigint NOT NULL AUTO_INCREMENT,
  `respondent_experience` int DEFAULT NULL,
  `respondent_name` varchar(255) DEFAULT NULL,
  `respondent_result` int DEFAULT NULL,
  PRIMARY KEY (`respondent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respondent`
--

LOCK TABLES `respondent` WRITE;
/*!40000 ALTER TABLE `respondent` DISABLE KEYS */;
INSERT INTO `respondent` VALUES (1,5,'Shura',3);
/*!40000 ALTER TABLE `respondent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `test_id` bigint NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'20 questions test');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_question`
--

DROP TABLE IF EXISTS `test_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_question` (
  `test_id` bigint NOT NULL,
  `question_id` bigint NOT NULL,
  PRIMARY KEY (`test_id`,`question_id`),
  KEY `FKk5qvcm9mkgbi8hm4u2mlidm4i` (`question_id`),
  CONSTRAINT `FKk2sfq1wyx19uvwn7pkgk1bc9n` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`),
  CONSTRAINT `FKk5qvcm9mkgbi8hm4u2mlidm4i` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_question`
--

LOCK TABLES `test_question` WRITE;
/*!40000 ALTER TABLE `test_question` DISABLE KEYS */;
INSERT INTO `test_question` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);
/*!40000 ALTER TABLE `test_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22  1:26:35
