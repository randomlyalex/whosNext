create table whosnext.users (
    uuid  uuid not null
        primary key,
    email varchar(255)
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    name  varchar(255)
);

create table whosnext.queue_items (
    uuid     uuid    not null
        primary key,
    position integer not null,
    queue_id uuid    not null,
    user_id  uuid    not null
        constraint fkb5fvrh5idivhwqxeip3hqhbp1
            references users
);

create table whosnext.queues (
    uuid uuid         not null
        primary key,
    name varchar(255) not null,
    head uuid         not null
        constraint uk_sedxcwtf42x64tmk3kh3am0j4
            unique
        constraint fk9kibkd18e4vhfjelpqr1tio96
            references queue_items,
    tail uuid         not null
        constraint uk_2x03029hon9jw0ti0k0g863xw
            unique
        constraint fkj4xjnfifg34vwjk961gq0k8pv
            references queue_items
);

alter table queues
owner to alexdodd;

alter table queue_items
add constraint fk1jfnwveuy81rovhq30yq1mqoi
    foreign key (queue_id) references queues;
