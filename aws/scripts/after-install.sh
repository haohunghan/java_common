#!/bin/bash
set -xe


# Copy war file from S3 bucket to tomcat webapp folder
aws s3 cp s3://nghao-test-deploy/demo-thymelef.war /usr/local/tomcat9/webapps/demo-thymelef.war


# Ensure the ownership permissions are correct.
chown -R tomcat:tomcat /usr/local/tomcat9/webapps