package main

import (
	"crypto/sha256"
	"encoding/hex"
	"fmt"
	"log"
)

func getSha256(str string) string {
	hash := sha256.New() // separate function creates new hash object everytime, otherwise the output will be wrong if same one is used both time
	hash.Write([]byte(str))
	shaHash := hex.EncodeToString(hash.Sum(nil))
	return shaHash
}

// GetEndpointSecretHash calculates endpoint secret hash as SHA256(endpoint.secret, SHA256(endpoint.id_hex + salt))
// salt is random string of length >= 1
//
// This is the Go implementation of the python script
// provided in the AA API doc https://www.netiq.com/documentation/advanced-authentication-63/apidoc/data/apidoc.html
func GetEndpointSecretHash(endpointID, endpointSecret, salt string) string {
	hash1 := getSha256(endpointID + salt)
	hash2 := getSha256(endpointSecret + hash1)

	log.Printf("hash1 = %v\n", hash1)
	log.Printf("hash2 = %v\n", hash2)
	return hash2
}

func main() {

	fmt.Print(GetEndpointSecretHash("178fa64ebafe11eaa1fb0242ac110003", "hVqFAFfQmfUqfrLMRf6y86Heslm3GtGt", "i_am_salt"))
}
