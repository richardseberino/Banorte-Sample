# Banorte-Sample
## 1 - Create a namespace
```oc create namespace banorte```

## 2 - Create configmaps
```
oc project banorte
oc create configmap liberty-config --from-file=server.xml
oc create configmap app-war --from-file=Sample01.war
oc create configmap driver-jdbc --from-file=mysql-driver.jar
```

## 3 - Deploy MySQL
### 3.1 - Start deploy
```
oc create -f service-account.yaml
oc create -f mysql-ss.yaml
oc create -f mysql-service.yaml

```
### 3.2 - Wait MySQL to startup
```
oc get pods 
```
### 3.3 - Create the database
```
oc cp mysql-script.sql mysql-0:/tmp/mysql-script.sql -n banorte
oc exec -ti mysql-0 -n banorte -- mysql -uroot -pxykjgs28 -e"source /tmp/mysql-script.sql;"
```

## 4 - Create Deployment
```
oc create -f deployment.yaml
oc create -f service.yaml
oc create -f route.yaml
```

## 5 - Retrieve the App URL
```
oc get route | grep app-sample | awk '{ print "http://"$2 "/Sample01"} '
```

