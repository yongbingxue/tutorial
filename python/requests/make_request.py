#!/usr/bin/env python
import requests

response = requests.get('https://api.github.com/events')
print(response.text.encode("UTF-8"))
