#version 400 core

in vec3 colour;

out vec4 outColour;

uniform vec4 uniformOutColour;

void main(void) {

	outColour = uniformOutColour;
	
}