import hashlib

def get_endpoint_secret_hash(endpoint_id, endpoint_secret, salt):
    # Calculates endpoint secret hash as SHA256(endpoint.secret, SHA256(endpoint.id_hex + salt))
    # salt is random string of length >= 1

    salted_endpoint_id = (endpoint_id + salt).encode('utf-8')
    print(salted_endpoint_id)
    endpoint_id_hash = hashlib.sha256(salted_endpoint_id).hexdigest()
    salted_enpoint_secret = (endpoint_secret + endpoint_id_hash).encode('utf-8')

    return hashlib.sha256(salted_enpoint_secret).hexdigest()

str = get_endpoint_secret_hash("178fa64ebafe11eaa1fb0242ac110003", "hVqFAFfQmfUqfrLMRf6y86Heslm3GtGt", "i_am_salt")
print(str)