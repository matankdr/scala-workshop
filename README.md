# Scala Workshop

<details>
<summary> Setup Environment </summary>

### Install [sdkman](https://sdkman.io/install)
```shell
curl -s "https://get.sdkman.io" | bash
```

### Install Java, Scala & SBT
From a new shell, run the following command:
```shell
sdk install java 17.0.9-oracle
sdk install scala 2.12.16
sdk install sbt 1.9.8
```

### Setup Wix Environment
- Install Wix environment as mentioned in [here](https://bo.wix.com/wix-docs/server-guild/get-started/scala-onboarding/nothing-to-prod/1.-setup-scala-development-environment)
- Setup Intellij plugins as mentioned in [here](https://github.com/wix-private/wix-intellij-plugin/blob/master/docs/plugin-getting-started.md)

### Verify Docker is working
Run the following command:
```shell
docker run --rm -p 8080:80 kennethreitz/httpbin
```
And browse to http://localhost:8080.
You should see the home page of HttpBin.
</details>

## Exercises

<details>
<summary>Exercise 1</summary>

### Base64 Decode
- Send a GET request to `http://localhost:8080/base64/{base64_encoded}`
- Example encoded message: `dmVsbyBpcyBhd2Vzb21lISEhISEK`
- Print the decoded response

</details> 

<details>
<summary>Exercise 2</summary>

### Redirect
- Send a GET request to `http://localhost:8080/redirect-to?url=http%3A%2F%2Flocalhost%3A8080%2Fuuid&status_code=200`
- Mark the request to not follow redirects (`requets.followRedirects(false)`)
- Parse the response
- Send another request according to the value in `Location` header
-
</details>

<details>
<summary>Exercise 3</summary>

### N redirects
- Send a GET request to `"http://localhost:8080/absolute-redirect/{N}"`
- Mark the request to not follow redirects (`requets.followRedirects(false)`)
- Parse the response
- Send another request according to the value in `Location` header
- Repeat until status code is 200
- print the result JSON
</details>

<details>
<summary>Exercise 4</summary>

### Parse JSON
- Send a GET request to `localhost:8080/stream/{N}`
- Parse the received JSON objects to collection of `HttpBinPayload`
</details>


## All supported endpoints
http://localhost:8080