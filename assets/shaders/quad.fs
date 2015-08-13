#version 400 core

in vec2 passTexCoords;

out vec4 outColour;

uniform sampler2D texSampler;

void main(void) {

	outColour = texture(texSampler, passTexCoords);
	
}