# NMC-REST Protocol

The namecoind-REST (NMC-REST) protocol is based on REST over HTTP. It is a
standard REST api which defines the following endpoints:

---

`/v1`

* Code: `200 OK`
* Content: <none>

For discovery of the supported versions of the NMC-REST protocol. Currently
there is only one version.

---

`/v1/n/<name>`

* Code: `200 OK`
* Content-Type: `application/json`
* Content: The return of `namecoind name_show <name>`, json encoded with no
newlines.

`<name>` is the url-encoded name of whatever value on the namecoind chain you
want to check the value of. For instance, here's the request/response for
`d/example` as of 12/31/2013:

```
/v1/n/d%2Fexample

{"name":"d/example","value":"RESERVED","txid":"c013e01acc3d1e4815a711d8bb106688e972fe2bf0072ff913c06fd9479419cf","address":"MyaRiHroQrmezvscNZ17BZbwEQL6zPue5D","expires_in":21531}
```

---

`/v1/n/<name>/<field>`

* Code: `200 OK`
* Content-Type: `text/plain`
* Content: The value at the given field on the given name on the namecoin
blockchain.

Both `<name>` and `<field>` are url-encoded. You can see the available
`<field>`'s by looking at the keys returned by `/v1/n/<name>`. The exact
available keys may change over time, but as of this writing they are:

* name
* value
* txid
* address
* expires_in

Here's the request/response for `d/example`'s `value` field:

```
/v1/n/d%2Fexample/value

RESERVED
```

---

For all other endpoints, or for cases where `<name>` is not found on the
blockchain, `404 NOT FOUND` is returned
