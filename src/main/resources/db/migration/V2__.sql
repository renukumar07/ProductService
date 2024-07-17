ALTER TABLE productservicemorningbatch.product
    ADD quantity INT NULL;

ALTER TABLE productservicemorningbatch.product
    MODIFY quantity INT NOT NULL;