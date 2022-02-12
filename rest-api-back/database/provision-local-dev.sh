#!/bin/bash
set -e

/etc/init.d/postgresql start
psql -f ./schema/v1-postgres.sql
/etc/init.d/postgresql stop
