---


---

<h1 id="oci-devops-cicd-with-tomcat-and-mysql">OCI DevOps CI/CD with Tomcat and MySQL</h1>
<p>This project automates the CI/CD pipeline for a Tomcat-based Java web application deployed on Oracle Kubernetes Engine ( OKE ). The application test connectivity with a MySQL database. The pipeline builds the application, packages it into a Docker image and deploy it to OKE</p>
<h1 id="components">Components</h1>
<ul>
<li>
<p><strong>Java Web Application</strong>: Servlet-based Java application that tests MySQL connectivity.</p>
</li>
<li>
<p><strong>MySQL Database</strong>: Configured through <code>mysql-app.yaml</code> and initialized with <code>mysql-init-script.yaml</code>.</p>
</li>
<li>
<p><strong>Tomcat Server</strong>: Hosts the Java web application (<code>tomcat-app.yaml</code>).</p>
</li>
<li>
<p><strong>Kubernetes Manifests</strong>:</p>
<ul>
<li>
<p><code>ingress.yaml</code>: Defines ingress rules for external access.</p>
</li>
<li>
<p><code>nginx-controller.yaml</code>: Manages Ingress traffic.</p>
</li>
<li>
<p><code>mysql-svc.yaml</code> &amp; <code>tomcat-svc.yaml</code>: Define Kubernetes services.</p>
</li>
<li>
<p><code>secret.yaml</code>: Stores sensitive configuration data.</p>
</li>
</ul>
</li>
<li>
<p><strong>Dockerfile</strong>: Defines the application image.</p>
</li>
<li>
<p><strong>build_spec.yaml</strong>: Specifies OCI DevOps pipeline build steps</p>
</li>
</ul>
<h2 id="technologies">Technologies</h2>
<ul>
<li><strong>Tomcat &amp; MySQL</strong>:</li>
<li><strong>Docker</strong>:</li>
<li><strong>GIT</strong>:</li>
<li><strong>OCI DevOps CI/CD</strong>:</li>
<li><strong>Kubernetes</strong>:</li>
</ul>
<h2 id="deployment">Deployment</h2>
<p>Currently the project is using the image stored in Oracle Container Registry and defined a secret for pulling images from the OCIR.</p>
<p>kubectl create secret docker-registry ocirsecret --docker-server=<a href="http://phx.ocir.io">phx.ocir.io</a> --docker-username=ansh81vru1zp/jdoe@acme.com --docker-password=‘k]j64r{1sJSSF-;)K8’ <a href="mailto:--docker-email=jdoe@acme.com">--docker-email=jdoe@acme.com</a></p>
<p>In order to manually deploy the application you can replace the image from tomcat-app.yaml from<br>
image: “<a href="http://bog.ocir.io/ocicustomeropshb/marius-oke:$%7BBUILDRUN_HASH%7D">bog.ocir.io/ocicustomeropshb/marius-oke:${BUILDRUN_HASH}</a>”  with “mariuslita/tomcat-app:latest”</p>

