USE `uuid_service`;

CREATE TABLE `UUIDMapping` (
  `uuid` binary(16) NOT NULL,
  `source` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `source_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
