alter table product add column active BOOLEAN;
UPDATE product SET active = true;