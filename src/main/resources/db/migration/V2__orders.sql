create table order_location
(
    id        bigint auto_increment
        primary key,
    date      datetime(6) null,
    latitude  double      null,
    longitude double      null
);


CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `operator_id` bigint NOT NULL,
  `end_order_location_id` bigint DEFAULT NULL,
  `start_order_location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_end_order_id` (`end_order_location_id`),
  KEY `FK_start_order_id` (`start_order_location_id`),
  CONSTRAINT `FK_end_order_id` FOREIGN KEY (`end_order_location_id`) REFERENCES `order_location` (`id`),
  CONSTRAINT `FK_start_order_id` FOREIGN KEY (`start_order_location_id`) REFERENCES `order_location` (`id`)
);

create table orders_assists
(
    order_id   bigint not null,
    assists_id bigint not null,
    constraint FK_orders_id_orders_assists
        foreign key (order_id) references orders (id),
    constraint FK_assist_id_orders_assists
        foreign key (assists_id) references assistances (id)
);

