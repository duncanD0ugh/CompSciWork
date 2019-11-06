ParticleList::ParticleList(ParticleList& original) {
	this->numParticles = original.numParticles;
	for(int i = 0; i < numParticles; i++)
		this->particles[i] = new Particle(*(original.particles[i]));
}
/*Takes a reference to the original object and puts it into a new object (this->)*/