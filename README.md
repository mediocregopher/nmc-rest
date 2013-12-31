# nmc-rest

A thin REST API on top of the namecoin blockchain.

Using nmc-rest you can access the values for names off of the namecoin
blockchain. You can access either all the properties for a name as a json object
or each one individually.

You can see the docs for the endpoints [here][proto]

## Usage

You can either download the most recent jar from the releases tab, or create it
yourself if you have Leinengen 2+:

```
git clone https://github.com/mediocregopher/nmc-rest.git
cd nmc-rest
lein uberjar
java -jar target/nmc-rest-*-standalone.jar
```

The standalone jar file can be moved anywhere. Try the `-h` option for more
help.

[proto]: /doc/proto.md
