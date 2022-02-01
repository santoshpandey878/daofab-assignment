create table transaction_information(
    id BIGINT PRIMARY KEY,
    sender VARCHAR(100),
    receiver VARCHAR(100),
    total_amount BIGINT
);

create table payment_installment(
    id BIGINT PRIMARY KEY,
    transaction_id bigint references transaction_information(id),
    paid_amount BIGINT
);
