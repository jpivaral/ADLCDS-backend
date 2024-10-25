from locust import HttpUser, task, between


class BackendLoadTest(HttpUser):
    wait_time = between(1, 3)

    @task
    def create_post(self):

        payload = {
                      "description": "this is a test"
                  }
        self.client.post(
            '/api/v1/posts',
            json=payload,
            name= 'POST api/v1/posts'
        )

    @task
    def get_all_posts(self):
        self.client.get(
            '/api/v1/posts',
            name= 'GET api/v1/posts'
        )