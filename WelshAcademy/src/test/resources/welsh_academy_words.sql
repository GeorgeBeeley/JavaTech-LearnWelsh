CREATE DATABASE  IF NOT EXISTS `welsh_academy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `welsh_academy`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: welsh_academy
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `words`
--

DROP TABLE IF EXISTS `words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `words` (
  `English` varchar(255) NOT NULL,
  `Welsh` varchar(255) NOT NULL,
  `gender` enum('M','F') NOT NULL,
  PRIMARY KEY (`English`,`Welsh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `words`
--

LOCK TABLES `words` WRITE;
/*!40000 ALTER TABLE `words` DISABLE KEYS */;
INSERT INTO `words` VALUES ('alligator','alligator','M'),('alligators','alligators','M'),('almonds','cnau almon','F'),('apple','afal','F'),('banana','banana','M'),('bathroom','ystafell ymolchi','F'),('beans','ffa','F'),('bear','arth','F'),('bears','yn dwyn','F'),('bed','gwely','M'),('bedroom','ystafell wely','F'),('bird','aderyn','M'),('birds','adar','M'),('bread','bara','M'),('breakfast','brecwast','M'),('bull','tarw','M'),('bulls','teirw','M'),('butter','menyn','M'),('candy','candy','F'),('carrot','moron','F'),('cat','cath','F'),('cats','cathod','F'),('ceiling','nenfwd','F'),('chair','cadeirydd','F'),('cheese','caws','M'),('chicken','cyw i','M'),('clothes','dillad','M'),('coat','cot','F'),('corn','yd','M'),('cow','buwch','F'),('cows','gwartheg','F'),('cucumber','ciwcymbr','M'),('cup','cup','M'),('deer','ceirw','M'),('desk','desg','F'),('dessert','pwdin','M'),('dinner','cinio','M'),('dog','ci','M'),('dogs','cwn','M'),('donkey','asyn','M'),('donkeys','asynnod','M'),('dress','ffrog','F'),('eagle','eryr','M'),('eagles','eryrod','M'),('elephant','eliffant','M'),('elephants','eliffantod','M'),('fish','pysgod','M'),('floor','llawr','M'),('food','bwyd','M'),('fork','fforc','F'),('fruit','ffrwythau','M'),('furniture','dodrefn','M'),('garlic','garlleg','M'),('giraffe','jiraff','M'),('giraffes','giraffes','M'),('glass','gwydr','M'),('goat','gafr','F'),('goats','geifr','F'),('grapes','grawnwin','M'),('hat','het','F'),('horse','ceffyl','M'),('horses','ceffylau','M'),('house','ty','M'),('ice cream','hufen ia','M'),('ink','inc','M'),('jacket','siaced','F'),('kitchen','cegin','F'),('knife','cyllell','F'),('lamb','cig oen','M'),('lamp','lamp','F'),('lemon','lemon','F'),('letter','llythyr','M'),('lettuce','letys','F'),('lion','llew','M'),('lions','lewod','M'),('lunch','cinio','M'),('many deer','llawer ceirw','M'),('map','map','F'),('meal','pryd','M'),('meat','cig','M'),('mice','llygod','F'),('monkey','mwnci','M'),('monkeys','mwnciod','M'),('mouse','llygoden','F'),('newspaper','papur newydd','M'),('notebook','notebook','M'),('objects','gwrthrychau','M'),('olives','olewydd','F'),('onions','winwns','M'),('oranges','orennau','M'),('oven','popty','F'),('paper','papur','M'),('peaches','eirin gwlanog','F'),('peanut','cnau mwnci','M'),('pears','gellyg','F'),('pen','pen','M'),('pencil','pensil','F'),('pepper','pupur','M'),('peppers','pupur','M'),('pharmacy','fferyllfa','F'),('picture','llun','M'),('pineapple','phin-afal','M'),('plants','planhigion','M'),('plate','Plat','M'),('pork','porc','M'),('potatoes','tatws','M'),('pumpkin','pwmpen','M'),('rabbit','cwningen','F'),('rabbits','cwningod','F'),('refrigerator','oergell','F'),('restaurant','bwyty','M'),('roof','to','M'),('room','ystafell','F'),('rug','hug','F'),('salad','salad','M'),('salt','halen','M'),('sandwich','brechdan','F'),('sausage','selsig','F'),('scissors','siswrn','M'),('shampoo','siampw','M'),('shirt','Crys','M'),('shoes','esgidiau','F'),('snake','neidr','F'),('snakes','nadroedd','F'),('soap','sebon','M'),('socks','Sanau','M'),('soup','Cawl','M'),('spoon','lwy','F'),('strawberries','mefus','F'),('sugar','siwgr','M'),('supper','swper','F'),('table','tabl','M'),('telephone','dros y ffon','F'),('tiger','teigr','M'),('tigers','teigrod','M'),('toilet','toiled','M'),('tomatoes','tomatos','M'),('toothbrush','brws dannedd','M'),('toothpaste','past dannedd','M'),('towel','liain','M'),('trousers','trowsus','M'),('turkey','twrci','M'),('umbrella','ymbarel','M'),('underwear','isaf','M'),('vegetables','llysiau','M'),('wall','wal','F'),('wallet','waled','F'),('window','ffenest','F'),('wolf','blaidd','M'),('wolves','blaidd','M');
/*!40000 ALTER TABLE `words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-02 22:34:14
